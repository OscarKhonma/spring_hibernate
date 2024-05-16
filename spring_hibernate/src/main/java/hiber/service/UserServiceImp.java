package hiber.service;

import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    public void addCar(Car car) {
        userDao.addCar(car);
    }

    @Transactional(readOnly = true)
    public List<Car> listCars() {
        return userDao.listCars();
    }

    @Transactional
    public User getUserByCar(String model, int series) {
        return userDao.getUserByCar(model, series);
    }

}
