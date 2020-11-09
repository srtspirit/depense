import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ArticleFacade } from '../../facades/article.facade';
import { Observable } from 'rxjs';
import { Article } from '../../models';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html'
})
export class ArticleListComponent implements OnInit {
  dropdownValues: any[] = [];
  @Output()
  selectedArticleChange: EventEmitter<Article> = new EventEmitter();

  constructor(private articleFacade: ArticleFacade) {}
  ngOnInit(): void {
    this.articleFacade.getArticles().subscribe(res => {
      this.dropdownValues = res.map(art => {
        return {
          text: art.name,
          callback: () => this.selectedArticleChange.emit(art)
        };
      });
    });
  }
}
