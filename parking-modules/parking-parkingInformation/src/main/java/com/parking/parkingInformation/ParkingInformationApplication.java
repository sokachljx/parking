package com.parking.parkingInformation;


import com.parking.common.security.annotation.EnableCustomConfig;
import com.parking.common.security.annotation.EnableRyFeignClients;
import com.parking.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 车位资讯模块
 *
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class ParkingInformationApplication {
    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(ParkingInformationApplication.class, args);
//
//        Object parkingSpaceInformationController = run.getBean("parkingSpaceInformationController");
        SpringApplication.run(ParkingInformationApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ 车位信息模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
