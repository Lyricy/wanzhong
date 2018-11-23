package shiro.realms;

import dao.DaoInf;
import model.Users;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ibatisRealm extends AuthorizingRealm {
    @Autowired
    private DaoInf dao;
    private static Logger logger = Logger.getLogger(ibatisRealm.class);

    /**
     * 认证回调接口
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        //2. 从 UsernamePasswordToken 中来获取 username
        String username = utoken.getUsername();
        logger.info("当前登陆用户："+username);
        if (StringUtils.isBlank(username)){
            logger.info("用户名或密码为空！");
            throw new AuthenticationException("用户名为空！");
        }
        //3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
        logger.info("从数据库中获取" + username + "信息...");
        List<Users> usersList = dao.getUsersByName(username);
        //4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
        if (null == usersList || usersList.size()==0){
            throw new UnknownAccountException("用户不存在");
        }
        logger.info("从数据库中获取" + username + "信息完成...");
        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //以下信息是从数据库中获取的.
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        String principal = username;
        //2). credentials: 密码.
//        String credentials = "812b8f890116da459f4b90630bb0dcac";
        String credentials = usersList.get(0).getPassword();
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        String realmName = getName();
        Users user = new Users(username,credentials);
        //4). 盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,credentials,credentialsSalt,realmName);
        return info;
    }

    /**
     * 授权回调接口
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("调用授权方法...");
        return null;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "lyricy";
        Object salt = ByteSource.Util.bytes("admin");;
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(result);
    }
}
