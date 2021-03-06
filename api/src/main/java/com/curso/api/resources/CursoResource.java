package com.curso.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.entities.Curso;
import com.curso.api.entities.dto.CursoDTO;
import com.curso.api.entities.mapper.CursoMapper;
import com.curso.api.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoMapper mapper;

	@GetMapping
	public ResponseEntity<List<Curso>> getCursos() {
		List<Curso> lista = cursoService.getCursos();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Integer id) {
		Curso curso = cursoService.findById(id);
		return ResponseEntity.ok().body(curso);
	}

	@GetMapping("/nome") // Exemplo: http://localhost:8080/curso/nome?valor=graduação
	public ResponseEntity<List<Curso>> findByNome(@RequestParam String valor) {
		List<Curso> cursos = cursoService.findByNome(valor);
		return ResponseEntity.ok().body(cursos);
	}

	@PostMapping
	public ResponseEntity<Curso> saveCurso(@Valid @RequestBody CursoDTO dto) throws URISyntaxException {

		Curso novoCurso = cursoService.save(mapper.setCursoDTOTOCurso(dto));
		return ResponseEntity.created(new URI(("/cursos/salvar/" + novoCurso.getId()))).body(novoCurso);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Curso> updateCurso(@Valid @RequestBody CursoDTO dto, @PathVariable Integer id)
			throws URISyntaxException {
		Curso novoCurso = mapper.setCursoDTOTOCurso(dto);
		novoCurso.setId(id);
		cursoService.update(novoCurso);
		return ResponseEntity.noContent().build();
	}

}
