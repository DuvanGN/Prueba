import { Component, OnInit } from '@angular/core';
import { TipoDocumento } from '../models/TipoDocumento';
import { ClienteService } from '../service/cliente.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  private titulo:string = "Ingresar Cliente"
  tipo: number = null;
  numero: number;
  email: string;
  cell: number;
  tiposDocumento: Array<TipoDocumento>;
  responseService: string = null;
  constructor(private clienteService:ClienteService) { }
  
  ngOnInit() {
    this.getTiposDocumentos();
  }

  public async crearCliente (){
    try {
      const response: string = await this.clienteService.registrarCliente(this.tipo, this.numero, this.email, this.cell).toPromise()
        this.responseService = response;
        setTimeout(() => {
          this.responseService = null;
          window.location.reload();
        }, 4000);      
    } catch (error) {
      console.error("Lo sentimos ocurrió un error al intentar ingresar un nuevo cliente.");
    }
  }

  private clearModels() : void {
    this.tipo = null;
    this.numero = null;
    this.email = null;
    this.cell = null;
  }

  private async getTiposDocumentos(): Promise<void> {
    try {
     this.tiposDocumento = await this.clienteService.getTiposDocumentos().toPromise();
    } catch (error) {
      console.error("Lo sentimos ocurrió un error al intentar obtener los tipos de documento");
    }
  }

}
