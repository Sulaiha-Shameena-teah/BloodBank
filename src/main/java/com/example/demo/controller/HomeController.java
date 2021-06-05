package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.AdminRepo;
import com.example.demo.dao.CountRepo;
import com.example.demo.dao.DonorRepo;
import com.example.demo.dao.NeedyRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.Admin;
import com.example.demo.model.BloodCount;
import com.example.demo.model.RequestBlood;
import com.example.demo.model.SaveBlood;
import com.example.demo.model.UserRegister;

@Controller
public class HomeController {
	
	
	@Autowired 
	UserRepo repo;
	
	@Autowired
	DonorRepo donorrepo;
	
	@Autowired 
	NeedyRepo needyrepo;
	
	@Autowired 
	AdminRepo adminrepo;
	
	@Autowired
	CountRepo countrepo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminLogin()
	{
		return "adminLogin.jsp";
	}
	
	@RequestMapping("/user")
	public String userLogin()
	{
		return "userLogin.jsp";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		return "register.jsp";
	}
	
	@RequestMapping("/adduser")
	public String adduser(UserRegister userregister)
	{
		System.out.println(userregister);
		repo.save(userregister);
		return "userLogin.jsp";
	}
	
	@RequestMapping("/userLogin")
	public String adduser(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		List<UserRegister> ur = repo.findAccount(name, password);
		System.out.println(ur);
		if(ur.size() == 1)
		{
			UserRegister currUser = ur.get(0);
			session.setAttribute("name", name);
			session.setAttribute("mobilenumber",currUser.getMobilenumber());
			session.setAttribute("userid",currUser.getU_id());
			
			List<RequestBlood> rb = needyrepo.findByUserId(currUser.getU_id());
			session.setAttribute("request", rb);
			
			List<SaveBlood> sb = donorrepo.findByUserId(currUser.getU_id());
			session.setAttribute("donor", sb);
			
			return "profile.jsp";
		}
		else
		{
			session.setAttribute("comment", "Invalid Username or Password");
		}
		return "userLogin.jsp";
	}
	
	@RequestMapping("/saveblood")
	public String saveblood(SaveBlood saveblood, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		Date date = new Date();
		String currDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
		saveblood.setDate(currDate);
		saveblood.setStatus("pending");
		donorrepo.save(saveblood);
		session.setAttribute("name", saveblood.getUsername());
		session.setAttribute("mobilenumber",saveblood.getMobilenumber());
		session.setAttribute("userid",saveblood.getUserid());
		
		List<RequestBlood> rb = needyrepo.findByUserId(saveblood.getUserid());
		session.setAttribute("request", rb);
		
		List<SaveBlood> sb = donorrepo.findByUserId(saveblood.getUserid());
		session.setAttribute("donor", sb); 
		
		return "profile.jsp";
	}
	
	@RequestMapping("/requestblood")
	public String requestblood(RequestBlood requestblood, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		Date date = new Date();
		String currDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
		requestblood.setDate(currDate);
		requestblood.setStatus("pending");
		needyrepo.save(requestblood);
		session.setAttribute("name", requestblood.getUsername());
		session.setAttribute("mobilenumber",requestblood.getMobilenumber());
		session.setAttribute("userid",requestblood.getUserid());
		
		List<RequestBlood> rb = needyrepo.findByUserId(requestblood.getUserid());
		session.setAttribute("request", rb);
		
		List<SaveBlood> sb = donorrepo.findByUserId(requestblood.getUserid());
		session.setAttribute("donor", sb); 
		
		
		return "profile.jsp";
	}
	
	@RequestMapping("/searchdonor")
	public String searchdonor(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("username"); 
		String userid = req.getParameter("userid"); 
		String mobilenumber = req.getParameter("mobilenumber");
		String bloodgroup = req.getParameter("bloodgroup");
		
		session.setAttribute("name", name);
		session.setAttribute("mobilenumber",mobilenumber);
		session.setAttribute("userid",userid);
		
		List<RequestBlood> rb = needyrepo.findByUserId(Integer.parseInt(userid));
		session.setAttribute("request", rb);
		
		List<SaveBlood> sb = donorrepo.findByUserId(Integer.parseInt(userid));
		session.setAttribute("donor", sb); 
		
		
		
		System.out.println(bloodgroup);
		List<SaveBlood> donorlist = donorrepo.findAllDonor(bloodgroup);
		System.out.println(donorlist);
		session.setAttribute("donorlist",donorlist);
		return "profile.jsp";
	}
	
	@RequestMapping("/adminLogin")
	public String adminLogin(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		List<Admin> ur = adminrepo.findAccount(name, password);
		System.out.println(ur);
		if(ur.size() == 1)
		{
			Admin currUser = ur.get(0);
			session.setAttribute("name", name);
			
			List<BloodCount> bloodcountList = countrepo.findAll();
			session.setAttribute("bloodcountList", bloodcountList);
			
			List<RequestBlood> rb = needyrepo.findAllbyStatus();
			session.setAttribute("requestlist", rb);
			
			List<SaveBlood> sb = donorrepo.findAllbyStatus();
			session.setAttribute("donorlist", sb);
			
			List<RequestBlood> rbAll = needyrepo.findAll();
			session.setAttribute("requestlistall", rbAll);
			
			List<SaveBlood> sbAll = donorrepo.findAll();
			session.setAttribute("donorlistall", sbAll);
			
			return "adminProfile.jsp";
		}
		session.setAttribute("comment", "Invalid Username or Password");
		return "adminLogin.jsp";
	}
	
	/*
	@RequestMapping("/bloodcount")
	public String bloodCount(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		
		session.setAttribute("name", name);
		
		
		
		return "adminProfile.jsp";
	}
	
	
	@RequestMapping("/requestList")
	public String requestList(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		List<RequestBlood> rb = needyrepo.findAll();
		session.setAttribute("name", name);
		session.setAttribute("requestlist", rb);
		return "adminProfile.jsp";
	}
	
	@RequestMapping("/donorList")
	public String donorList(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		List<SaveBlood> sb = donorrepo.findAll();
		session.setAttribute("name", name);
		session.setAttribute("donorlist", sb);
		return "adminProfile.jsp";
	}
	*/
	@RequestMapping("/acceptRequest")
	public String acceptRequest(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		
		int requestid = Integer.parseInt(req.getParameter("requestid"));
		System.out.println(requestid);
		
		int units = Integer.parseInt(req.getParameter("units"));
		System.out.print(units);
		
		
		
		
		String bloodgroup = req.getParameter("bloodgroup");
		BloodCount bloodCountIn = countrepo.bloodCountInParticularGroup();
		System.out.println(bloodgroup+" "+bloodCountIn);
		
		String mapper = bloodCountIn.findMapper(bloodgroup);
		System.out.println(mapper);
		
			
		
		int valueOfMapper = bloodCountIn.valueMapper(mapper);
		System.out.print(valueOfMapper);
		
		if(valueOfMapper >= units)
		{
			needyrepo.acceptRequestWithid(requestid);
		
			if(mapper.equals("apos"))
				countrepo.UpdateBloodCountapos(valueOfMapper-units);
			
			if(mapper.equals("bpos"))
				countrepo.UpdateBloodCountbpos(valueOfMapper-units);
			
			if(mapper.equals("abpos"))
				countrepo.UpdateBloodCountabpos(valueOfMapper-units);
			
			if(mapper.equals("opos"))
				countrepo.UpdateBloodCountopos(valueOfMapper-units);
			
			if(mapper.equals("aneg"))
				countrepo.UpdateBloodCountaneg(valueOfMapper-units);
			
			if(mapper.equals("bneg"))
				countrepo.UpdateBloodCountbneg(valueOfMapper-units);
			
			if(mapper.equals("abneg"))
				countrepo.UpdateBloodCountabneg(valueOfMapper-units);
			
			if(mapper.equals("oneg"))
				countrepo.UpdateBloodCountoneg(valueOfMapper-units);
			
			BloodCount bloodCount2 = countrepo.bloodCountInParticularGroup();
			System.out.println("After update "+bloodCount2);
		}
		else
		{
			System.out.print("Insufficient");
		}
		
		
		List<BloodCount> bloodcountList = countrepo.findAll();
		session.setAttribute("bloodcountList", bloodcountList);
		
		List<RequestBlood> rb = needyrepo.findAllbyStatus();
		session.setAttribute("requestlist", rb);
		
		List<SaveBlood> sb = donorrepo.findAllbyStatus();
		session.setAttribute("donorlist", sb);
		
		List<RequestBlood> rbAll = needyrepo.findAll();
		session.setAttribute("requestlistall", rbAll);
		
		List<SaveBlood> sbAll = donorrepo.findAll();
		session.setAttribute("donorlistall", sbAll);
		
		
		return "adminProfile.jsp";
	}
	
	@RequestMapping("/rejectRequest")
	public String rejectRequest(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		
		int requestid = Integer.parseInt(req.getParameter("requestid"));
		System.out.println(requestid);
		
		needyrepo.rejectRequestWithid(requestid);
		
		List<BloodCount> bloodcountList = countrepo.findAll();
		session.setAttribute("bloodcountList", bloodcountList);
		
		List<RequestBlood> rb = needyrepo.findAllbyStatus();
		session.setAttribute("requestlist", rb);
		
		List<SaveBlood> sb = donorrepo.findAllbyStatus();
		session.setAttribute("donorlist", sb);
		
		List<RequestBlood> rbAll = needyrepo.findAll();
		session.setAttribute("requestlistall", rbAll);
		
		List<SaveBlood> sbAll = donorrepo.findAll();
		session.setAttribute("donorlistall", sbAll);
		
		return "adminProfile.jsp";
	}
	
	@RequestMapping("/acceptDonor")
	public String acceptDonor(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		
		int requestid = Integer.parseInt(req.getParameter("requestid"));
		System.out.println(requestid);
		
		donorrepo.acceptRequestWithid(requestid);
		
		String bloodgroup = req.getParameter("bloodgroup");
		BloodCount bloodCountIn = countrepo.bloodCountInParticularGroup();
		System.out.println(bloodgroup+" "+bloodCountIn);
		
		String mapper = bloodCountIn.findMapper(bloodgroup);
		System.out.println(mapper);
		
		int valueOfMapper = bloodCountIn.valueMapper(mapper);
		System.out.print(valueOfMapper);
		
		if(mapper.equals("apos"))
			countrepo.UpdateBloodCountapos(valueOfMapper+1);
		
		if(mapper.equals("bpos"))
			countrepo.UpdateBloodCountbpos(valueOfMapper+1);
		
		if(mapper.equals("abpos"))
			countrepo.UpdateBloodCountabpos(valueOfMapper+1);
		
		if(mapper.equals("opos"))
			countrepo.UpdateBloodCountopos(valueOfMapper+1);
		
		if(mapper.equals("aneg"))
			countrepo.UpdateBloodCountaneg(valueOfMapper+1);
		
		if(mapper.equals("bneg"))
			countrepo.UpdateBloodCountbneg(valueOfMapper+1);
		
		if(mapper.equals("abneg"))
			countrepo.UpdateBloodCountabneg(valueOfMapper+1);
		
		if(mapper.equals("oneg"))
			countrepo.UpdateBloodCountoneg(valueOfMapper+1);
		
		BloodCount bloodCount2 = countrepo.bloodCountInParticularGroup();
		System.out.println("After update "+bloodCount2);
		
		
		
		
		List<RequestBlood> rb = needyrepo.findAllbyStatus();
		session.setAttribute("requestlist", rb);
		
		List<SaveBlood> sb = donorrepo.findAllbyStatus();
		session.setAttribute("donorlist", sb);
		
		List<RequestBlood> rbAll = needyrepo.findAll();
		session.setAttribute("requestlistall", rbAll);
		
		List<SaveBlood> sbAll = donorrepo.findAll();
		session.setAttribute("donorlistall", sbAll);
		
		List<BloodCount> bloodcountList = countrepo.findAll();
		session.setAttribute("bloodcountList", bloodcountList);
		
		return "adminProfile.jsp";
	}
	
	@RequestMapping("/rejectDonor")
	public String rejectDonor(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		String name = req.getParameter("name");
		session.setAttribute("name", name);
		
		int requestid = Integer.parseInt(req.getParameter("requestid"));
		System.out.println(requestid);
		
		donorrepo.rejectRequestWithid(requestid);
		
		List<BloodCount> bloodcountList = countrepo.findAll();
		session.setAttribute("bloodcountList", bloodcountList);
		
		List<RequestBlood> rb = needyrepo.findAllbyStatus();
		session.setAttribute("requestlist", rb);
		
		List<SaveBlood> sb = donorrepo.findAllbyStatus();
		session.setAttribute("donorlist", sb);
		
		List<RequestBlood> rbAll = needyrepo.findAll();
		session.setAttribute("requestlistall", rbAll);
		
		List<SaveBlood> sbAll = donorrepo.findAll();
		session.setAttribute("donorlistall", sbAll);
		
		
		
		return "adminProfile.jsp";
	}
	
	
}
