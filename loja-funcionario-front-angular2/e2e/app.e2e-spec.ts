import { LojaFuncionariosPage } from './app.po';

describe('loja-funcionarios App', function() {
  let page: LojaFuncionariosPage;

  beforeEach(() => {
    page = new LojaFuncionariosPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
