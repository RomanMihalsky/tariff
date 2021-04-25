import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Tariff } from 'src/app/model/tariff';
import { TariffService } from 'src/app/service/tariff.service';

@Component({
  selector: 'app-main-tariff',
  templateUrl: './main-tariff.component.html',
  styleUrls: ['./main-tariff.component.css']
})
export class MainTariffComponent implements OnInit {
  public tariffs: Tariff[];
  public editTariff: Tariff = new Tariff();
  public deleteTariff: Tariff;

  constructor(private tariffService:TariffService,private router:Router) { }

  ngOnInit(): void {
    this.getTariffs();
  }

  public getTariffs() :void{
    this.tariffService.getList().subscribe(
      (response: Tariff[]) =>{
        console.log(response);
        this.tariffs = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  public onAddTariff(addForm: NgForm): void {
    document.getElementById('add-tariff-form')!.click();
    this.tariffService.create(this.changeValue(addForm)).subscribe(
      (response: Tariff) => {
        console.log(response);
        this.getTariffs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onOpenModal(tariff: Tariff, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addTariffModal');
    }
    if (mode === 'edit') {
      this.editTariff= tariff;
      button.setAttribute('data-target', '#updateTariffModal');
    }
    if (mode === 'delete') {
      this.deleteTariff = tariff;
      button.setAttribute('data-target', '#deleteTariffModal');
    }
    container!.appendChild(button);
    button.click();
  }

  public onUpdateTariff(tariff: Tariff): void {
    this.tariffService.update(tariff).subscribe(
      (response: Tariff) => {
        console.log(response);
        this.getTariffs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  public onDeleteTariff(tariffId: number): void {
    this.tariffService.delete(tariffId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTariffs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        this.getTariffs();
      }
    );
  }

  public searchTariffs(key: string): void {
    console.log(key);
    const results: Tariff[] = [];
    for (const tariff of this.tariffs) {
      if (tariff.name.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(tariff);
      }
    }
    this.tariffs = results;
    if (results.length === 0 || !key) {
      this.getTariffs();
    }
  }

  changeValue(form: NgForm):Tariff{
    var tariff:Tariff = new Tariff();
    tariff.id = 0;
    tariff.name = form.value.name;
    tariff.price = form.value.price;
    tariff.imageUrl = form.value.imageUrl;
    tariff.speed = form.value.speed;
    tariff.wifi = true;
    return tariff;
  }
}
