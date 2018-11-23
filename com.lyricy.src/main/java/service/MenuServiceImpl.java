package service;

import dao.DaoInf;
import model.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private DaoInf dao;
    @Override
    public List<Functions> getMenuByName(String username) {
        List<Functions> functions = dao.getMenuByName(username);
        List<Functions> retFuns = new ArrayList<Functions>();
        List<Functions> child = new ArrayList<Functions>();
        for (Functions func:functions) {
            if ("1".equals(func.getFunction_level())){
                retFuns.add(func);
            }else {
                child.add(func);
            }
        }
        for (Functions function:retFuns) {
            for (Functions childf:child) {
                if (function.getId().equals(childf.getUp_function())){
                    function.getChildrenList().add(childf);
                }
            }
        }
        return retFuns;
    }
}
