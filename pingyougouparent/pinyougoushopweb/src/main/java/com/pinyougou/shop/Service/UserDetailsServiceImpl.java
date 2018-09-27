package com.pinyougou.shop.Service;

import com.pingyougou.pojo.TbSeller;
import com.pingyougou.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

public class UserDetailsServiceImpl implements UserDetailsService {


    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList <GrantedAuthority> grantedAuthorities = new ArrayList <>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SELLER" ));
        //查询用户名
        TbSeller one = sellerService.findOne(username);
        System.out.println("查询用户信息");
        if(one!=null){
            if(one.getStatus().equals("1")){

            String password = one.getPassword();
                System.out.println(username);
                System.out.println(password);


                return new User(username,password,grantedAuthorities);}
            else {return null ;}
        }else {
            return null;
        }


    }
}
