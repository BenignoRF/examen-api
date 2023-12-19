package com.examen.examenapi.controller;

import com.examen.examenapi.model.Empresa;
import com.examen.examenapi.service.EmpresaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empresa")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping("/saludar")
    public String saluda(){
        return "Hola Benigno";
    }

    @PostMapping("/save")
    public ResponseEntity saveEmrpesa(@RequestBody Empresa empresa){
        return new ResponseEntity(empresaService.saveEmpresa(empresa), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getAllEmpresa(@PathVariable("id") Long id){
        return new ResponseEntity(empresaService.getAllEmrpesa(id), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editEmrpesa(@PathVariable("id") Long id, @RequestBody Empresa empresa){
        return new ResponseEntity(empresaService.editEmpresa(id, empresa), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmpresa(@PathVariable("id") Long id){

        boolean respuesta = empresaService.deleteEmpresa(id);
        if (respuesta == true){
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
