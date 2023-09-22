import { Component } from '@angular/core';
import { post } from '../Post';
import { PostService } from '../post.detail';


@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent {
  postId: number = 0;
  post: post | null = null;

  constructor(private postService: PostService) {}

  fetchPostById() {
    this.postService.getPostById(this.postId).subscribe((result) => {
      this.post = result;
    });
  }
}
