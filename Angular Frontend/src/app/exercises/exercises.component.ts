import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser'
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { NgRedux, select } from '@angular-redux/store';
import { IAppState } from '../store/store';
import { REMOVE_ALL_TODOS } from '../store/action/actions';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.scss']
})
export class ExercisesComponent implements OnInit {
  @select() todos;
  @select() lastUpdate;
  @select() test;

  exerciseList = [];
  exercise = '';


  constructor(private titleService: Title, private http: HttpClient, private ngredux: NgRedux<IAppState>) {
    this.titleService.setTitle('Exercises');
  }

  ngOnInit() {
    this.getData();
  }

  handleExerciseClick(event) {
    this.exercise = event.target.textContent;
    // console.log(this.exerciseList.find(exercise => exercise.name === this.exercise).id)
  }

  getData() {
    this.ngredux.dispatch({type: REMOVE_ALL_TODOS});

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };

    return this.http.get('http://localhost:8080/exercises', httpOptions)
      .subscribe(data => {
        this.exerciseList = JSON.parse(JSON.stringify(data));
        console.log(this.exerciseList);
      })
  }

}
