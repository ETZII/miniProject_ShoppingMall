package com.yejishop.portfolio.member;

import lombok.Data;

@Data
public class MemberVO {
  private String userId;  
  private String userPassword;
  private String userPhone ;
  private String userAddr1 ;
  private String userAddr2 ;
  private String userAddr3 ;
  private String userAddr4 ;
  private String userName  ;
  private int 	 userAge;
  private String userGender ;
  private String userGrade ;
  private String userEtc ;	
  private String searchCondition;
  private String searchKeyword;
  private String userRegdate;
}