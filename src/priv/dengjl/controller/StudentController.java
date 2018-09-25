package priv.dengjl.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import priv.dengjl.entity.Student;
import priv.dengjl.service.StudentService;

/*
默认为singleton单例模式，对应配置中的<bean scope="prototype"/>
 */
@Scope(value = "prototype")
/*
 * 请求映射，链接地址第一层满足指定的value则进入这个控制类中的方法
 */
@RequestMapping(value = "/manager")
/*
 * 指定当前类为控制类，value可以重命名（无法自动装配）
 * 不使用注解时，需实现org.springframework.web.servlet.mvc.Controller接口
 */
@Controller
public class StudentController {
	/*
	 * 指定Service，需要在Spring中配置相关注解扫描（自动装配） 可以使用
	 * 
	 * @Autowired@Qualifier(value = "StuService") 进行配置，也可以使用
	 * 
	 * @Resource
	 */
	@Resource(name = "StuService")
	private StudentService studentService;

	/*
	 * value为数组，可以设置多个链接，method为请求方式
	 */
	@RequestMapping(value = "/add.html", method = RequestMethod.GET)
	public String addStu(
			// 如果链接中有数据的获取方法，value为链接中的名称，required = false为可缺省
			@RequestParam(value = "info", required = false) String msg,

			// 以下写出后会自动装配，可省略不写
			HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model// 可以用Map<String,Object>代替
	) throws RuntimeException {
		// 模拟页面传入了注册的信息
		Student student = new Student();
		student.setNo(9999);
		student.setLoginPwd("123123");
		student.setName("张三");
		student.setSex((byte) 2);
		student.setGradeId(2);
		student.setPhone("13512312312");
		student.setAddress("测试地址");
		student.setBirthdate(new Date());
		student.setEmail("123@123.com");
		student.setIdentityCard("123123123123123123");

		// 执行增加
		int n = studentService.addStu(student);
		if (n == 0) {
			// jsp页面中，使用${msg}即可获取
			model.addAttribute("msg", "增加" + student.getName() + "成功");
			// 手动抛出异常
			throw new RuntimeException("添加失败");
		} else {
			// jsp页面中，使用${msg}即可获取
			model.addAttribute("msg", "增加" + student.getName() + "成功");
		}
		// 使用index的视图呈现，前后缀见视图解析器配置
		return "index";
	}

	@RequestMapping(value = "/find.html", method = RequestMethod.GET)
	public String findStuById(@RequestParam(value = "id") String stuId, Model model) {
		Student student = studentService.findStuById(Integer.parseInt(stuId));
		model.addAttribute("msg", student.getName());
		return "index";
	}

	@RequestMapping(value = "/update.html", method = RequestMethod.GET)
	public String updateStu(Model model) {
		Student student = new Student();
		student.setNo(9999);
		student.setLoginPwd("asdasdasdsad");
		student.setName("李四");
		student.setSex((byte) 1);
		student.setGradeId(1);
		student.setPhone("13500000000");
		student.setAddress("测试地址12313215");
		student.setBirthdate(new Date());
		student.setEmail("123@dsad.com");
		student.setIdentityCard("12345123412121234");
		int n = studentService.updateStu(student);
		model.addAttribute("msg", "更新" + n + "条记录");
		return "index";
	}
	
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public String listStudent(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "listStudent";
	}

	@RequestMapping(value = "/delete.html", method = RequestMethod.GET)
	public String deleteStu(Model model) {
		int n = studentService.deleteStu(9999);
		model.addAttribute("msg", "删除" + n + "条记录");
		return "index";
	}

	@RequestMapping(value = "/getGrade.html", method = RequestMethod.GET)
	public String getStudentsGrade(HttpServletRequest request, Model model) {
		List<Student> studentList = studentService.getStudentsGrade();
		model.addAttribute("msg", "获取到" + studentList.size() + "条记录");
		request.setAttribute("stuList", studentList);// 前台页面用小脚本即可获取遍历
		return "index";
	}

	@RequestMapping(value = "/getResult.html", method = RequestMethod.GET)
	public String getStudentResults(@RequestParam("stuNo") String stuNO, HttpServletRequest request, Model model) {
		Student student = studentService.getStudentResults(Integer.parseInt(stuNO));
		model.addAttribute("msg", "获取到" + student.getName() + "的记录");
		request.setAttribute("stu", student);// 前台页面用小脚本即可获取遍历
		return "index";
	}

	/*
	 * 全局异常处理配置 <bean class=
	 * "org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
	 * <property name="exceptionMappings"> <props> <prop
	 * key="java.lang.RuntimeException">error</prop> </props> </property>
	 * </bean> 以下为局部异常处理方式
	 */
	@ExceptionHandler(value = { RuntimeException.class })
	public String error(RuntimeException e, HttpServletRequest request) {
		request.setAttribute("e", e);// jsp页面显示 ${e.getMessage()}
		return "error";// 跳转到异常页面
	}
}