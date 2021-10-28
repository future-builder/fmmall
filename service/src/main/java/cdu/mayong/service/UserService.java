package cdu.mayong.service;

import cdu.mayong.vo.ResultVo;

public interface UserService {
    ResultVo userRegister(String username, String password);

    ResultVo checkLogin(String username, String password);
}
