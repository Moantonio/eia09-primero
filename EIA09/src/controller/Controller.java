package controller;

import view.View;
import model.Model;

public interface Controller {

	public void setView(View view);

	public void setModel(Model model);

	public void refreshView();
}
