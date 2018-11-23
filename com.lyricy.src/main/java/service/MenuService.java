package service;

import model.Functions;
import org.springframework.stereotype.Service;

import java.util.List;
public interface MenuService {
    public List<Functions> getMenuByName(String username);
}
