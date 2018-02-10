package kr.go;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class LibApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibApplication.class, args);
	}
}
