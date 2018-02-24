package kr.go;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/**
 *
 */
@SpringBootApplication
//@MapperScan("com.libraryCMS")
@MapperScan("kr.go")
@EnableCaching
@EnableAspectJAutoProxy
public class LibApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LibApplication.class, args);
	}

	/**
	 * Used when run as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(LibApplication.class);
	}

}
