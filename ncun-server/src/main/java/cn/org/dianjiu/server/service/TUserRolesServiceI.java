package cn.org.dianjiu.server.service;

import cn.org.dianjiu.common.pojo.req.PageReq;
import cn.org.dianjiu.common.pojo.req.TUserRolesReq;
import cn.org.dianjiu.common.pojo.resp.TUserRolesResp;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 用户角色操作(TUserRoles)表服务接口
 *
 * @author dianjiu
 * @since 2021-06-11 11:38:14
 */
public interface TUserRolesServiceI {

    TUserRolesResp getById(Integer id);

    TUserRolesResp getByEntity(TUserRolesReq tUserRolesReq);

    List<TUserRolesResp> listByEntity(TUserRolesReq tUserRolesReq);

    List<TUserRolesResp> listByIds(List<Integer> ids);

    PageInfo<TUserRolesResp> listByPage(PageReq<TUserRolesReq> pageReq);

    int insert(TUserRolesReq tUserRolesReq);

    int insertBatch(List<TUserRolesReq> list);

    int update(TUserRolesReq tUserRolesReq);

    int updateBatch(List<TUserRolesReq> list);

    int deleteById(Integer id);

    int deleteByEntity(TUserRolesReq tUserRolesReq);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(TUserRolesReq tUserRolesReq);
}
