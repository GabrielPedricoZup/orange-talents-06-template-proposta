package com.gabrielpedrico.proposta.proposta.configs.schedules;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@EnableScheduling
public class ImageSchedule {

    @Scheduled(fixedRate=120000)
    public void exibeImagem(){
        System.out.println("████▀░░░░░░░░░░░░░░░░░▀████");
        System.out.println("███│░░░░░░░░░░░░░░░░░░░│███");
        System.out.println("██▌│░░░░░░░░░░░░░░░░░░░│▐██");
        System.out.println("██░└┐░░░░░░░░░░░░░░░░░┌┘░██");
        System.out.println("██░░└┐░░░░░░░░░░░░░░░┌┘░░██");
        System.out.println("██░░┌┘▄▄▄▄▄░░░░░▄▄▄▄▄└┐░░██");
        System.out.println("██▌░│██████▌░░░▐██████│░▐██            DEV: Gabriel Pedrico");
        System.out.println("███░│▐███▀▀░░▄░░▀▀███▌│░███            API: Proposta");
        System.out.println("██▀─┘░░░░░░░▐█▌░░░░░░░└─▀██            STATUS: Rodando...");
        System.out.println("██▄░░░▄▄▄▓░░▀█▀░░▓▄▄▄░░░▄██            ENDPOINTS: /proposta       [POST]");
        System.out.println("████▄─┘██▌░░░░░░░▐██└─▄████                       /proposta/{id}   [GET]");
        System.out.println("█████░░▐█─┬┬┬┬┬┬┬─█▌░░█████                       /biometria/{id} [POST]");
        System.out.println("████▌░░░▀┬┼┼┼┼┼┼┼┬▀░░░▐████");
        System.out.println("█████▄░░░└┴┴┴┴┴┴┴┘░░░▄█████");
        System.out.println("███████▄░░░░░░░░░░░▄█████");
    }
}
