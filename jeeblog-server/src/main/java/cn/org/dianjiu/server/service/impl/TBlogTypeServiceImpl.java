package cn.org.dianjiu.server.service.impl;

import cn.org.dianjiu.server.dao.TBlogTypeDao;
import cn.org.dianjiu.server.service.TBlogTypeServiceI;
import cn.org.dianjiu.server.entity.TBlogType;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.List;

/**
 * (TBlogType)表服务实现类
 *
 * @author makejava
 * @since 2020-09-04 15:06:14
 */
@Slf4j
@Service
public class TBlogTypeServiceImpl implements TBlogTypeServiceI {

    @Autowired
    private TBlogTypeDao tBlogTypeDao;
    
    @Override
    public TBlogTypeResp getById(Integer id) {
        TBlogTypeResp tBlogTypeResp = new TBlogTypeResp();
        TBlogType tBlogType = tBlogTypeDao.getById(id);
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogType)){
            log.error("根据id【"+id+"】没有查到相关记录！");
            throw new BusinessException("400","根据id【"+id+"】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogType,tBlogTypeResp);
        return tBlogTypeResp;
    }
    
    @Override
    public TBlogTypeResp getByEntity(TBlogTypeReq tBlogTypeReq) {
      TBlogTypeResp tBlogTypeResp = new TBlogTypeResp();
        TBlogType tBlogType = new TBlogType();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
        TBlogType tBlogType1 = tBlogTypeDao.getByEntity(tBlogType);
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogType1)){
            log.error("根据tBlogTypeReq【"+tBlogTypeReq+"】没有查到相关记录！");
            throw new BusinessException("400","根据tBlogTypeReq【"+tBlogTypeReq+"】没有查到相关记录！");
        }
        ObjectUtils.copyProperties(tBlogType1,tBlogTypeResp);
        return tBlogTypeResp;
    }
    
    @Override
    public List<TBlogTypeResp> listByEntity(TBlogTypeReq tBlogTypeReq) {
        List<TBlogTypeResp> list = new ArrayList<>();
        TBlogType tBlogType = new TBlogType();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
        List<TBlogType> tBlogTypes = tBlogTypeDao.listByEntity(tBlogType);
        if(null == tBlogTypes || tBlogTypes.isEmpty()){
            log.error("根据tBlogTypeReq【"+tBlogTypeReq+"】没有查到相关记录！");
            throw new BusinessException("400","根据tBlogTypeReq【"+tBlogTypeReq+"】没有查到相关记录！");
        }
        for (TBlogType tBlogType1 : tBlogTypes ) {
            TBlogTypeResp tBlogTypeResp = new TBlogTypeResp();
            if(ObjectUtils.checkObjAllFieldsIsNull(tBlogType1)){
                log.error("根据tBlogTypeReq【"+tBlogTypeReq+"】没有查到相关记录！");
                throw new BusinessException("400","根据tBlogTypeReq【"+tBlogTypeReq+"】没有查到相关记录！");
            }
            ObjectUtils.copyProperties(tBlogType1,tBlogTypeResp);
            list.add(tBlogTypeResp);
        }
        return list;
    }

    @Override
    public List<TBlogTypeResp> listByIds(List<Integer> ids) {
      List<TBlogTypeResp> list = new ArrayList<>();
        if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            throw new BusinessException("400","id集合不能为空！");
        }
        List<TBlogType> tBlogTypes  = tBlogTypeDao.listByIds(ids);
        if(null != tBlogTypes && !tBlogTypes.isEmpty()){
            for (TBlogType tBlogType1 : tBlogTypes ) {
                TBlogTypeResp tBlogTypeResp = new TBlogTypeResp();
                if(ObjectUtils.checkObjAllFieldsIsNull(tBlogType1)){
                    log.error("根据ids【"+ids.toString()+"】没有查到相关记录！");
                    throw new BusinessException("400","根据ids【"+ids.toString()+"】没有查到相关记录！");
                }
                ObjectUtils.copyProperties(tBlogType1,tBlogTypeResp);
                list.add(tBlogTypeResp);
            }
        }
        return list;
    }
    
    @Override
    public int insert(TBlogTypeReq tBlogTypeReq) {
      TBlogType tBlogType = new TBlogType();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
        Date date = new Date();
        tBlogType.setCreateTime(date);
        tBlogType.setUpdateTime(date);
        return tBlogTypeDao.insert(tBlogType);
    }

    @Override
    public int insertBatch(List<TBlogTypeReq> list) {
      List<TBlogType> tBlogTypes = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量插入的集合为空！");
            throw new BusinessException("400","执行批量插入的集合为空！");
        }
        for (TBlogTypeReq tBlogTypeReq : list) {
            TBlogType tBlogType = new TBlogType();
            if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
                log.error("执行批量插入的集合为空！");
                throw new BusinessException("400","执行批量插入的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
            tBlogTypes.add(tBlogType);
        }
        return tBlogTypeDao.insertBatch(tBlogTypes);
    }
    
    @Override
    public int update(TBlogTypeReq tBlogTypeReq) {
      TBlogType tBlogType = new TBlogType();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
        tBlogType.setUpdateTime(new Date());
        return tBlogTypeDao.update(tBlogType);
    }
    
    @Override
    public int updateBatch(List<TBlogTypeReq> list) {
      List<TBlogType> tBlogTypes = new ArrayList<>();
        if(null == list || list.isEmpty()){
            log.error("执行批量更新的集合为空！");
            throw new BusinessException("400","执行批量更新的集合为空！");
        }
        for (TBlogTypeReq tBlogTypeReq : list) {
            TBlogType tBlogType = new TBlogType();
            if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
                log.error("执行批量更新的集合为空！");
                throw new BusinessException("400","执行批量更新的集合为空！");
            }
            ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
            tBlogTypes.add(tBlogType);
        }
        return tBlogTypeDao.updateBatch(tBlogTypes);
    }

    @Override
    public int deleteById(Integer id) {
        return tBlogTypeDao.deleteById(id);
    }
    
    @Override
    public int deleteByEntity(TBlogTypeReq tBlogTypeReq) {
      TBlogType tBlogType = new TBlogType();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
        return tBlogTypeDao.deleteByEntity(tBlogType);
    }
    
    @Override
    public int deleteByIds(List<Integer> ids) {
      if(null == ids || ids.isEmpty()){
            log.error("id集合不能为空！");
            throw new BusinessException("400","id集合不能为空！");
        }
        return tBlogTypeDao.deleteByIds(ids);
    }
    
    @Override
    public int countAll() {
        return tBlogTypeDao.countAll();
    }
    
    @Override
    public int countByEntity(TBlogTypeReq tBlogTypeReq) {
      TBlogType tBlogType = new TBlogType();
        if(ObjectUtils.checkObjAllFieldsIsNull(tBlogTypeReq)){
            log.error("入参对象不能为空！");
            throw new BusinessException("400","入参对象不能为空！");
        }
        ObjectUtils.copyProperties(tBlogTypeReq,tBlogType);
        return tBlogTypeDao.countByEntity(tBlogType);
    }

}