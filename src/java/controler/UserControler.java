/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import bean.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.UserFacade;

/**
 *
 * @author Youness
 */
@ManagedBean
@SessionScoped
public class UserControler {

    private User user=new User();
    private List<User>users=new ArrayList<>();
    @EJB
    private UserFacade userFacade;

    
    @PostConstruct
    public void init(){
    users=userFacade.findAll();
    }
    
   
    private User cloneUsr(){
    User u=user;
        return u;
    }
    
    public String save(){
      userFacade.create(user);
      users.add(cloneUsr());
        return "/list.xhtml";
    }
    
    public String update(User usr){
        userFacade.edit(usr);
    return null;
    } 
    
    public String delete(User usr){
      userFacade.remove(usr);
    return null;
    }
    
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
    
    
    
    public UserControler() {
    }
    
}
