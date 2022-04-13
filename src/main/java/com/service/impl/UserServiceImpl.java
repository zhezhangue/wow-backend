package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bean.Response;
import com.dto.LoginDTO;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.utils.cache.IGlobalCache;
import com.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 继承mybatis-plus<M, T>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    final static String USER_NAME = "admin";
    final static String PWD = "admin";

    @Autowired
    private IGlobalCache globalCache;

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public Response<UserVO> login(LoginDTO loginDTO) {
//        User user = getByName(loginDTO.getName());
//
//        //用户信息校验和查询
//        if (user == null){
////            throw new ServiceException(ResultCodeEnum.LOGIN_FAIL);
//            return new Response<>(null);
//        }
//        //密码校验
//        if(!PWD.equals(loginDTO.getPassword())){
////            throw new ServiceException(ResultCodeEnum.LOGIN_FAIL);
//            return new Response<>(null);
//        }
//
//        //缓存用户信息并设置过期时间
//        UserVO userVO = new UserVO();
//        userVO.setName(user.getName());
//        userVO.setId(user.getId());
//        userVO.setToken(JWTUtils.generate(user.getId()));
//
//        //信息入库redis
//        globalCache.set(RedisKeyEnum.OAUTH_APP_TOKEN.keyBuilder(userVO.getUid()), JSONObject.toJSONString(userVO), timeout);
//
        return null;
    }


//    /**
//     * 通过用户名获取用户
//     * @param name
//     * @return
//     */
//    public User getByName(String name){
//        User user = null;
//        if(USER_NAME.equals(name)){
//            user =  new User();
//            user.setName("张三");
//            user.setPassword("Aa123456");
//        }
//        return user;
//    }

}
