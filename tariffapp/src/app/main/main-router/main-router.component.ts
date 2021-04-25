import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RouterR } from 'src/app/model/router';
import { RouterService } from 'src/app/service/router.service';

@Component({
  selector: 'app-main-router',
  templateUrl: './main-router.component.html',
  styleUrls: ['./main-router.component.css']
})
export class MainRouterComponent implements OnInit{
  public routerRs: RouterR[];
  public editRouterR: RouterR = new RouterR();
  public deleteRouterR: RouterR;

  constructor(private routerRService:RouterService,private router: Router ) { }

  ngOnInit(): void {
    this.getRouterRs();
  }

  public getRouterRs() :void{
    this.routerRService.getList().subscribe(
      (response: RouterR[]) =>{
        console.log(response);
        this.routerRs = response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  public onAddRouterR(addForm: NgForm): void {
    document.getElementById('add-routerr-form')!.click();
    this.routerRService.create(this.changeValue(addForm)).subscribe(
      (response: RouterR) => {
        console.log(response);
        this.getRouterRs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onOpenModal(routerR: RouterR, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addRouterRModal');
    }
    if (mode === 'edit') {
      this.editRouterR= routerR;
      button.setAttribute('data-target', '#updateRouterRModal');
    }
    if (mode === 'delete') {
      this.deleteRouterR = routerR;
      button.setAttribute('data-target', '#deleteRouterRModal');
    }
    container!.appendChild(button);
    button.click();
  }

  public onUpdateRouterR(routerR: RouterR): void {
    this.routerRService.update(routerR).subscribe(
      (response: RouterR) => {
        console.log(response);
        this.getRouterRs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  public onDeleteRouterR(routerRId: number): void {
    this.routerRService.delete(routerRId).subscribe(
      (response: void) => {
        console.log(response);
        this.getRouterRs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        this.getRouterRs();
      }
    );
  }

  changeValue(form: NgForm):RouterR{
    var routerR:RouterR = new RouterR();
    routerR.id = 0;
    routerR.name = form.value.name;
    routerR.price = form.value.price;
    routerR.imageUrl = form.value.imageUrl;
    routerR.description = form.value.description;
    routerR.company = form.value.company;
    return routerR;
  }
}
