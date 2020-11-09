export interface Entity {
  id?: string;
  entityName: string;
}

export class Receipt implements Entity {
  readonly entityName = 'receipt';
  date = new Date();
  amount = 0;
  expenses = [];
}

export class Expense implements Entity {
  readonly entityName = 'expense';
  date = new Date();
  purchase: string;
  amount = 0;
  article = new Article();
}

export class Article implements Entity {
  readonly entityName = 'article';
  name?: string;
  parentArticleId?: string;
  childArticles?: Article[];
}
