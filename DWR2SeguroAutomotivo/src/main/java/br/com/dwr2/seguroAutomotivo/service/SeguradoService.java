package br.com.dwr2.seguroAutomotivo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dwr2.seguroAutomotivo.entidades.PessoaFisica;
import br.com.dwr2.seguroAutomotivo.entidades.PessoaJuridica;
import br.com.dwr2.seguroAutomotivo.entidades.Segurado;
import br.com.dwr2.seguroAutomotivo.entidades.Telefone;
import br.com.dwr2.seguroAutomotivo.repository.EnderecoRepository;
import br.com.dwr2.seguroAutomotivo.repository.SeguradoRepository;
import br.com.dwr2.seguroAutomotivo.repository.TelefoneRepository;

@Service
public class SeguradoService {

	@Autowired
	private SeguradoRepository seguradoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Transactional(rollbackFor = Exception.class)
	public boolean salvar(Segurado segurado) {
		if (segurado != null) {
			try {
				if (segurado instanceof PessoaFisica) {
					PessoaFisica pFisica = (PessoaFisica) segurado;
					if (insertPessoaFisica(pFisica)) {
						return true;
					} else if (segurado instanceof PessoaJuridica) {
						PessoaJuridica pJuridica = (PessoaJuridica) segurado;
						if (insertPessoaJuridica(pJuridica)) {
							return true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private boolean insertPessoaJuridica(PessoaJuridica pessoaJuridica) {

		if (pessoaJuridica != null) {
			seguradoRepository.save(pessoaJuridica);
			if (pessoaJuridica.getEndereco() != null) {
				enderecoRepository.save(pessoaJuridica.getEndereco());
			}
			if (!pessoaJuridica.getTelefones().isEmpty() && pessoaJuridica.getTelefones() != null) {
				for (Telefone t : pessoaJuridica.getTelefones()) {
					if (t != null) {
						telefoneRepository.save(t);
					}
				}
			}
			return true;
		}
		return false;
	}

	private boolean insertPessoaFisica(PessoaFisica pessoaFisica) {

		if (pessoaFisica != null) {
			seguradoRepository.save(pessoaFisica);
			if (pessoaFisica.getEndereco() != null) {
				enderecoRepository.save(pessoaFisica.getEndereco());
			}
			if (!pessoaFisica.getTelefones().isEmpty() && pessoaFisica.getTelefones() != null) {
				for (Telefone t : pessoaFisica.getTelefones()) {
					if (t != null) {
						telefoneRepository.save(t);
					}
				}
			}
			return true;
		}
		return false;
	}
}
