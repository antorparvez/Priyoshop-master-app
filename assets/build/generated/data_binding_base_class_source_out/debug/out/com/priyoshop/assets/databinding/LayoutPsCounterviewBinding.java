// Generated by view binder compiler. Do not edit!
package com.priyoshop.assets.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.priyoshop.assets.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutPsCounterviewBinding implements ViewBinding {
  @NonNull
  private final View rootView;

  @NonNull
  public final AppCompatImageButton btnDecrease;

  @NonNull
  public final AppCompatImageButton btnIncrease;

  private LayoutPsCounterviewBinding(@NonNull View rootView,
      @NonNull AppCompatImageButton btnDecrease, @NonNull AppCompatImageButton btnIncrease) {
    this.rootView = rootView;
    this.btnDecrease = btnDecrease;
    this.btnIncrease = btnIncrease;
  }

  @Override
  @NonNull
  public View getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutPsCounterviewBinding inflate(@NonNull LayoutInflater inflater,
      @NonNull ViewGroup parent) {
    if (parent == null) {
      throw new NullPointerException("parent");
    }
    inflater.inflate(R.layout.layout_ps_counterview, parent);
    return bind(parent);
  }

  @NonNull
  public static LayoutPsCounterviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_decrease;
      AppCompatImageButton btnDecrease = ViewBindings.findChildViewById(rootView, id);
      if (btnDecrease == null) {
        break missingId;
      }

      id = R.id.btn_increase;
      AppCompatImageButton btnIncrease = ViewBindings.findChildViewById(rootView, id);
      if (btnIncrease == null) {
        break missingId;
      }

      return new LayoutPsCounterviewBinding(rootView, btnDecrease, btnIncrease);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}