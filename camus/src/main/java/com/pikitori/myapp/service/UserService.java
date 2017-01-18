package com.pikitori.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pikitori.myapp.vo.UserVo;


@Repository
public class UserService {

	public List<UserVo> getAllUsers() {
		List<UserVo> list = new ArrayList<UserVo>();

		UserVo user = new UserVo();
		user.setId(1L);
		user.setName("¾È´ëÇõ");
		user.setPhone("010-4761-6934");
		user.setEmail("kickscar@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-1/p160x160/936089_1019758748039064_7187347097932848216_n.jpg?oh=d7f1b684d98039f57995a7bada9120d7&oe=58B949B2");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(2L);
		user.setName("È«¸¶¿À");
		user.setPhone("010-4761-6934");
		user.setEmail("maohong@gmail.com");
		user.setProfilePic(
				"https://scontent.xx.fbcdn.net/v/t1.0-1/c13.13.166.166/s160x160/562300_158663031006306_366519961_n.jpg?oh=c0cc8d2bbd3c32b410ae9efbef65fa50&oe=57DD538F");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(3L);
		user.setName("Å«Çü´Ô");
		user.setPhone("010-4761-6934");
		user.setEmail("bigbrother@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/1186118_146279165582758_1233784670_n.jpg?oh=a24bc568aa5092897f71cd4baabcb125&oe=58BC55BE");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(4L);
		user.setName("±è½½±â");
		user.setPhone("010-4761-6934");
		user.setEmail("kimsmu@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/1044955_138730762999533_171992422_n.jpg?oh=1aa35ae7699d63fdaf12bba63b379841&oe=58C3AD1D");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(5L);
		user.setName("±èÇæÅ©");
		user.setPhone("010-4761-6934");
		user.setEmail("hulk@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/562300_158663031006306_366519961_n.jpg?oh=6d97ede4a6272bd4352b79ac5400d75a&oe=58C66151");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(6L);
		user.setName("ÀÌÀ±ÀÓ");
		user.setPhone("010-4761-6934");
		user.setEmail("yilee@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/970872_131001340439142_72401859_n.jpg?oh=3d8d77ed4bc46446d9e126db7890571b&oe=58F633AF");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(7L);
		user.setName("È«³×¸ð");
		user.setPhone("010-4761-6934");
		user.setEmail("recthong@gmail.com");
		user.setProfilePic(
				"https://scontent.xx.fbcdn.net/v/t1.0-9/1186118_146279165582758_1233784670_n.jpg?oh=1b583df1824869960964ff168f30705f&oe=57CF07BE");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(8L);
		user.setName("ÀÌ¿ìº¸");
		user.setPhone("010-4761-6934");
		user.setEmail("jingjing@gmail.com");
		user.setProfilePic(
				"https://scontent.xx.fbcdn.net/v/t1.0-9/945025_125511240992884_1798446283_n.jpg?oh=c1c1ac824b1d2ccc08d34d1adb6fbe8d&oe=580E25AF");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(9L);
		user.setName("¹Ú»§");
		user.setPhone("010-4761-6934");
		user.setEmail("ppang@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/15056421_1118764964904759_3487310309091770003_n.jpg?oh=0df3323729e239d1d9602715e3243557&oe=58F536EB");
		user.setStatus(1);
		list.add(user);

		user = new UserVo();
		user.setId(10L);
		user.setName("µå¸²¿÷½º");
		user.setPhone("010-4761-6934");
		user.setEmail("morison@gmail.com");
		user.setProfilePic(
				"https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/13244704_1192288654129059_9040112177709593214_n.jpg?oh=ee9c7e5ef89e449f5e1dbcf04a159d03&oe=58F66F22");
		user.setStatus(1);
		list.add(user);

		return list;

	}

}
