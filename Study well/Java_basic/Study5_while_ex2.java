package com.iu.study2;

import java.util.Random;
import java.util.Scanner;

public class Study5_while_ex2 {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		//TRPG
		int hp = 40; //유저의 HP
		int monsterHp = 60; //몬스터의 HP
		int monsterPower = 40; //몬스터의 공격력
		
		//유저 정보 : hp, 몬스터 정보: hp 등등
		//1. 평타  2. 스킬  3. HP회복 4.도망
		//평타 : 0~10 미만의 공격이 몬스터에게 적용
		//스킬 : 0~30 미만의 공격이 몬스터에게 적용(최대3번까지만)
		//회복 : 회복량 0~40 까지 회복. 40을 넘어가면 40고정
		//도망 : 50%확률로 성공, 실패
	    	
		
		//monster
		//1 : 유저 공격  0~40의 공격을 유저에게 
		
		
		//누가 죽던 도망가던 종료합니다. 출력
		int skill = 3;
		int run = 1;
		boolean b= true;
		
		while(hp>0 && monsterHp>0 && b) {
			System.out.println("현재 당신의 체력은 "+hp+"입니다.");
			System.out.println("현재 몬스터 체력은 "+monsterHp+"입니다.");
			
			
			System.out.println("당신은 무얼 하시겠습니까?");
			System.out.println("1.평타 2.스킬 3.HP회복 4.도망");
			int act = sc.nextInt();
			
			   if(act==1) {
			    	monsterHp -= random.nextInt(10);
			    	System.out.println("몬스터에게 평범한 일격을 가합니다.");
			   }
			   else if(act==2) {
		            if(skill>0) {
				      monsterHp -= random.nextInt(30);
				      System.out.println("스킬을 사용합니다!");		      
				      skill--;
				    }else {
				      System.out.println("스킬을 더 이상 사용할 수 없습니다.");
			        }
		       }
			   else if(act==3) {
				       hp += random.nextInt(40);
				    if(hp>40){
					   hp = 40;
				    }
			   }else {
				  run = random.nextInt(2);
				  if(run==1) {
				    	System.out.println("몬스터에게서 도망쳤습니다");
				    	break;	
				  }
				  System.out.println("도망에 실패했습니다");
			   }
			//몬스터의 공격
			System.out.println("몬스터가 당신을 공격합니다");
			hp -= random.nextInt(40);
			
		}
		System.out.println("내 Hp : "+hp);
		System.out.println("적의 남은 Hp: "+monsterHp);
		if(hp>monsterHp) {
			System.out.println("전투에서 승리하셨습니다");
		} else if(hp<0) {
			System.out.println("전투에서 패배하셨습니다");
		}
		System.out.println("전투가 종료됩니다");
		}	
	
	}

