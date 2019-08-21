import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { HttpService } from 'src/app/service/httpservice'
import { MatSnackBar } from '@angular/material';
import { forgotModel } from "src/app/model/forgotModel";

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.scss']
})
export class ForgotpasswordComponent implements OnInit {
  forgot: forgotModel = new forgotModel ()
  emailId: string;
  forgotpasswordForm: FormGroup;
  constructor(private snackBar: MatSnackBar,
    private httpservice: HttpService,
    public formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.forgotpasswordForm = this.formBuilder.group(
      {
      
        'emailId': new FormControl(this.forgot.emailId, [Validators.required])

      }
    )
  }

  onSubmit() {
    console.log(this.forgot )
    this.httpservice.postRequest("forgetpassword",this.forgot).subscribe(
      (response: any) => {
        if (response.statusCode == 200) {
          console.log(response);
          this.snackBar.open(
            "Link sent Successfully",
            "undo",
            { duration: 2500 }
          )
        } else {
          console.log(response);
          this.snackBar.open(
            "Password Setting Failed",
            "undo",
            { duration: 2500 }
          )
        }
      }
    );
  }

}