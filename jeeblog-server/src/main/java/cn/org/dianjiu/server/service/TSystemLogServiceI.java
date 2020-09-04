package cn.org.dianjiu.server.service;

import cn.org.dianjiu.server.dao.TSystemLogDao;

import java.util.List;

/**
 * (TSystemLog)表服务接口
 *
 * @author makejava
 * @since 2020-09-04 15:06:17
 */
public interface TSystemLogServiceI {
     
    TSystemLogResp getById(Integer id);

    TSystemLogResp getByEntity(TSystemLogReq tSystemLogReq);

    List<TSystemLogResp> listByEntity(TSystemLogReq tSystemLogReq);

    List<TSystemLogResp> listByIds(List<Integer> ids);

    int insert(TSystemLogReq tSystemLogReq);

    int insertBatch(List<TSystemLogReq> list);

    int update(TSystemLogReq tSystemLogReq);

    int updateBatch(List<TSystemLogReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TSystemLogReq tSystemLogReq);
  
    int deleteByIds(List<Integer> list);
    
    int countAll();
    
    int countByEntity(TSystemLogReq tSystemLogReq);
}