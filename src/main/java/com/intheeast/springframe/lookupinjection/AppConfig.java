package com.intheeast.springframe.lookupinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	
	@Bean
    @Scope("prototype")
    public AsyncCommand asyncCommand() {
        AsyncCommand command = new AsyncCommand();
        // 필요에 따라 여기서 의존성 주입
        return command;
    }

    @Bean
    public CommandManager commandManager() {
        // createCommand()를 오버라이드하여 새로운 프로토타입 Command 객체를 반환하는
        // CommandManager의 익명 구현 반환
        return new CommandManager() {
        	
            protected Command createCommand() {
                return asyncCommand();
            }
        };
    }


}
