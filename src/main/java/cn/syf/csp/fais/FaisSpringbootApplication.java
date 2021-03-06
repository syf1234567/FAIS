package cn.syf.csp.fais;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("cn.syf.csp.fais.mapper")
@EnableSwagger2
public class FaisSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaisSpringbootApplication.class, args);
	}

}
