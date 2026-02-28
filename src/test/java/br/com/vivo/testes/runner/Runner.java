package br.com.vivo.testes.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // ou "classpath:features" conforme sua pasta
        glue = "br.com.vivo.testes.steps", // <--- AQUI: adicione o .steps
        tags = "@validacao_erro",
        plugin = {"pretty", "html:target/report-cucumber.html"}
)
public class Runner {
}