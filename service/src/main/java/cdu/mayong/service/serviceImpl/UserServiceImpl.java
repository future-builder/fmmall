package cdu.mayong.service.serviceImpl;

import cdu.mayong.dao.UsersMapper;
import cdu.mayong.entity.Users;
import cdu.mayong.service.UserService;
import cdu.mayong.utils.MD5Utils;
import cdu.mayong.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UsersMapper usersMapper;

    @Transactional
    @Override
    public ResultVo userRegister(String username, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);

        List<Users> users = usersMapper.selectByExample(example);

        if (users.isEmpty()){
            Users user = new Users();
            user.setUsername(username);
            password = MD5Utils.md5(password);
            user.setPassword(password);
            user.setUserImg("img/default.png");
            user.setUserRegtime(new Date());
            user.setUserModtime(new Date());

            int res = usersMapper.insert(user);
            if (res == 1) {
                return new ResultVo(200, "注册成功。", user);
            } else {
                return new ResultVo(10002, "出错了，请重试。", null);
            }
        }else{
            return new ResultVo(10001, "用户名已存在。", null);
        }
    }

    @Override
    public ResultVo checkLogin(String username, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<Users> users = usersMapper.selectByExample(example);

        if (!users.isEmpty()){
            password = MD5Utils.md5(password);
            Users user = users.get(0);
            if (user.getPassword().equals(password)) {
                return new ResultVo(200, "登陆成功", user);
            } else {
                return new ResultVo(10002, "密码错误", null);
            }
        } else {
            return new ResultVo(10001, "用户名不存在", null);
        }

    }
}
