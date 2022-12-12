package tn.esprit.etudiantservice.Configuration;

import lombok.extern.slf4j.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;


/**
 * @author Jozef
 */
@Slf4j
@Component
@Aspect
public class LoggingAspect {
    @Before(" execution(* tn.esprit.etudiantservice.services.ContratImpl.*(..)) ")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After(" execution(* tn.esprit.etudiantservice.services.ContratImpl.*(..)) ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info(" Out of method " + name + " : ");
    }
}
