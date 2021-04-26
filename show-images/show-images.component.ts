import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'show-images',
  templateUrl: './show-images.component.html',
  styleUrls: ['./show-images.component.css']
})
export class ShowImagesComponent  {


  imageUrl="";

  changeImage(fld){
    this.imageUrl=  "assets/"+fld.value+".jpg";
  }
}
