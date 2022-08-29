package com.xyc.jpademo.service;

import com.xyc.jpademo.entity.User;
import com.xyc.jpademo.param.UserParam;
import com.xyc.jpademo.repository.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String login(HttpSession session, User user) {
        // 查询
        User resultUser = userRepository.findByUsername(user.getUsername());
        if (resultUser !=null){
            session.setAttribute("loginUser",user);
            return "ok";
        }else{
            return "error";
        }
    }

    @Override
    public List<User> findUser(UserParam userParam)
    {
        Specification<User> specification = new Specification<User>() {
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (userParam.getUsername() != null && !"".equals(userParam.getUsername())) {
                    predicates.add(cb.equal(root.<String>get("username"), userParam.getUsername()));
                }
                if (userParam.getUsercode() != null && !"".equals(userParam.getUsercode())) {
                    predicates.add(cb.equal(root.<String>get("usercode"), userParam.getUsercode()));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<User> users = userRepository.findAll(specification);
        return users;

    }
}
