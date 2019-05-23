package ayds.spotisong.aurora.song.view;

import ayds.spotisong.aurora.song.presenter.SearchSongPresenter;

import javax.swing.*;

class SearchSongWindow implements SearchSongView {
  JPanel contentPane;
  private JTextField queryTextField;
  private JButton goButton;
  private JButton openInSpotifyButton;
  private JLabel windowTitle;
  private JTextPane songDescriptionText;

  final private SearchSongPresenter presenter;

  SearchSongWindow(SearchSongPresenter presenter) {

    this.presenter = presenter;
    initListeners();
  }

  @Override
  public String getQuery() {
    return queryTextField.getText();
  }

  @Override
  public void setSongDescription(String description) {
    songDescriptionText.setText(description);
  }

  @Override
  public void enableActionButtons() {
    openInSpotifyButton.setEnabled(true);
  }

  @Override
  public void disableActionButtons() {
    openInSpotifyButton.setEnabled(false);
  }

  private void initListeners() {
    goButton.addActionListener(e -> presenter.onSongSearch());

    openInSpotifyButton.addActionListener(e -> presenter.onOpenUrl());
  }
}
