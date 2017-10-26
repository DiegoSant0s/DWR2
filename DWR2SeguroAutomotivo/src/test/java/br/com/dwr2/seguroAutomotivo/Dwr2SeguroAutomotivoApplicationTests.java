package br.com.dwr2.seguroAutomotivo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dwr2.seguroAutomotivo.entidades.Endereco;
import br.com.dwr2.seguroAutomotivo.entidades.PessoaFisica;
import br.com.dwr2.seguroAutomotivo.entidades.TipoPessoa;
import br.com.dwr2.seguroAutomotivo.service.SeguradoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Dwr2SeguroAutomotivoApplicationTests {

	@Autowired
	private SeguradoService service;

	private PessoaFisica pFisica = new PessoaFisica();
	private Endereco endereco = new Endereco();
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void salvarSegurado() {
		
		pFisica.setNome("Diego");
		pFisica.setDataCadastro(new Date());
		pFisica.setCpf("08271335456");
		pFisica.setTipo(TipoPessoa.FISICA);
		endereco.setCep("52280143");
		endereco.setSegurado(pFisica);
		pFisica.setEndereco(endereco);
		service.salvar(pFisica);
		
	}

}
