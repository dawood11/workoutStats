import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExercisesComponent } from './exercises/exercises.component';
import { NewExerciseComponent } from './new-exercise/new-exercise.component';

const routes: Routes = [
  {
    path: 'exercises',
    component: ExercisesComponent
  },
  {
    path: 'new-exercise',
    component: NewExerciseComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
