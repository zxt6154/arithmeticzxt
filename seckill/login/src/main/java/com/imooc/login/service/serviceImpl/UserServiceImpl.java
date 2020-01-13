package com.imooc.login.service.serviceImpl;

import com.imooc.login.dao.UserMapper;
import com.imooc.login.domain.User;
import com.imooc.login.domain.UserTest;
import com.imooc.login.domain.vo.LoginVo;
import com.imooc.login.exception.GlobalException;
import com.imooc.login.redis.RedisService;
import com.imooc.login.redis.UserKey;
import com.imooc.login.results.CodeMsg;
import com.imooc.login.utils.MD5Util;
import com.imooc.login.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl /*implements UserService */{  //！！！！！！！！！！！！！！！！！！！！！！！getbyid

   public static final String COOKIE_NAME_TOKENONE= "token";
 //  public static final String COOKIE_NAME_TOKENTWO= "token";
    @Autowired
    UserMapper userDao;
    @Autowired
    RedisService redisService;

    public User getById(Long id){
    return userDao.getById(id);
    }
    public boolean login(HttpServletResponse response, LoginVo loginVo){
           if(loginVo == null){throw new GlobalException(CodeMsg.SERVER_ERROR); }

            String mobile = loginVo.getMobile();
            String formPass = loginVo.getPassword();
            //判断手机号是否存在
            User user = getById(Long.parseLong(mobile));
            if (user == null){throw new GlobalException(CodeMsg.MOBILE_NOTEXIST);}
            //验证密码
            String dbPass = user.getPassword();
            String saltDB = user.getSalt();
            //推算出密码
            String calcPass = MD5Util.formPassDBPass(formPass,saltDB);
            if(!calcPass.equals(dbPass)){throw new GlobalException(CodeMsg.PASSWORD_ERROR);}
            //生成token
            String token = UUIDUtil.uuid();
            addCookie(response,token,user);
            return true;

        }
        //生成cookie
        public void addCookie(HttpServletResponse response,String token, User user){
            redisService.set(UserKey.token,token,user);
            Cookie cookie = new Cookie(COOKIE_NAME_TOKENONE,token);
            cookie.setMaxAge(UserKey.token.expireSeconds());
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        public User getByToken(HttpServletResponse response,String token) {

                if(StringUtils.isEmpty(token)){
                    return null;
                }
            //取缓存
            User user  = redisService.get(UserKey.token,token,User.class);
            //延长token时间
            //判断是否有user ,有说明有缓存
            if(user != null){
               addCookie(response,token,user);
            }
            return user;
        }


    public List<UserTest> testdb() {
        List<UserTest> list = userDao.getList();
        return list;
    }
}
