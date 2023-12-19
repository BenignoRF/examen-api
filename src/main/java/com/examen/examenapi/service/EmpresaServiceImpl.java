package com.examen.examenapi.service;


import com.examen.examenapi.model.Empresa;
import com.examen.examenapi.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService{

    private final EmpresaRepository empresaRepository;

    @Override
    public Empresa saveEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Optional<Empresa> getAllEmrpesa(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    @Override
    public Empresa editEmpresa(Long id, Empresa editEmpresa) {
        Empresa findEmpresa = empresaRepository.findById(id).get();
        findEmpresa.setEstado(editEmpresa.getEstado());
        return empresaRepository.save(findEmpresa);
    }

    @Override
    public boolean deleteEmpresa(Long id) {
        try {
            empresaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
