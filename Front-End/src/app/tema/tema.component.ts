import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Tema } from '../model/Tema';
import { TemaService } from '../service/tema.service';

@Component({
  selector: 'app-tema',
  templateUrl: './tema.component.html',
  styleUrls: ['./tema.component.css']
})
export class TemaComponent implements OnInit {

    tema: Tema = new Tema()
    ListaTemas: Tema[]

  constructor(
    private router: Router,
    private temaService: TemaService
  ) { }

  ngOnInit() {

    window.scroll(0,0)

    if(environment.token == '') {
      this.router.navigate(['/entrar'])
    }

    this.findAllTemas()
  }

  findAllTemas() {
    this.temaService.getAlltema().subscribe((resp: Tema[])=> {
      this;this.ListaTemas= resp

    })
  }

  cadastrar() {
    this.temaService.postTema(this.tema).subscribe((resp: Tema)=> {
      this.tema = resp
      alert('tema cadastrado com sucesso!')
      this.findAllTemas()
      this.tema = new Tema()
    })
  }

}
