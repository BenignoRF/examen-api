package com.examen.examenapi.service;


import com.examen.examenapi.model.Empresa;

import java.util.Optional;

public interface EmpresaService {

    Empresa saveEmpresa(Empresa empresa);
    Optional<Empresa> getAllEmrpesa (Long idEmpresa);
    Empresa editEmpresa(Long id, Empresa editEmpresa);
    boolean deleteEmpresa(Long id);
}
