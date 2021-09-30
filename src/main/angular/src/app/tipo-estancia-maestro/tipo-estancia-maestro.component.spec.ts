import { ComponentFixture, ComponentFixtureAutoDetect, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { TipoEstanciaService } from '../service/tipo-estancia.service';

import { TipoEstanciaMaestroComponent } from './tipo-estancia-maestro.component';

describe('TipoEstanciaMaestroComponent', () => {
  let component: TipoEstanciaMaestroComponent;
  let fixture: ComponentFixture<TipoEstanciaMaestroComponent>;
  let spyTipoService: jasmine.SpyObj<TipoEstanciaService>;

  beforeEach( () => {
     TestBed.configureTestingModule({
      declarations: [ TipoEstanciaMaestroComponent ],
      imports: [RouterTestingModule,
      FormsModule],
      providers: [
        { provide: ComponentFixtureAutoDetect, useValue: true },
        {
          provide: TipoEstanciaService,
            useValue: jasmine.createSpyObj('TipoEstanciaService', ['getTiposActivos'])
        }  
      ]
    }).compileComponents();

    let spyService = TestBed.get(TipoEstanciaService);

    spyService.getTiposActivos.and.returnValue(of([{id:1, nombre: 'Cafetera', descripcion: 'Máquina que hace café', activo: true},
    {id:2, nombre: 'Bolígrafo', descripcion: 'Sirve para escribir', activo: true},
    {id:3, nombre: 'Goma', descripcion: 'Sirve para borrar algo que se ha apuntado', activo: true},
    {id:4, nombre: 'Libreta', descripcion: 'Se usa para realizar anotaciones', activo: true}]
    ));

    fixture = TestBed.createComponent(TipoEstanciaMaestroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  
});
