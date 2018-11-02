package com.springboot.service.imp;

import com.springboot.mapper.StudentMapper;
import com.springboot.mapper.UserMapper;
import com.springboot.model.Student;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImp implements UserService {

/*
    @Autowired
    private UserDao userDao;
*/

    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentMapper studentMapper;


/*
    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }
*/

    @Override
    public User getUserByid(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public boolean insertUser(User user) throws Exception{

            boolean b=false;
            Student student=new Student();
            student.setId(1);
            student.setUid(user.getId());
            student.setStudent("刘老师");

            userMapper.insert(user);
            studentMapper.insert(student);
            b=true;

        return b;
    }


}
