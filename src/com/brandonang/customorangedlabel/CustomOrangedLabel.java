package com.brandonang.customorangedlabel;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.widget.FrameLayout;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;

public class CustomOrangedLabel extends AndroidNonvisibleComponent {
  private Activity activity;
  private Context context;
  private boolean enableBackgroundColor;
  private int orangeLabColor;

  public CustomOrangedLabel(ComponentContainer container) {
    super(container.$form());
    this.activity = container.$context();
    this.context = container.$context();
  }
  
  @DesignerProperty(defaultValue = "False", editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
  @SimpleProperty(description = "Sets background color")
  public void SetBackgroundColor(boolean isBackgroundColor){
    enableBackgroundColor = isBackgroundColor;
  }

  @DesignerProperty(defaultValue = DEFAULT_VALUE_COLOR_ORANGE, editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR)
  @SimpleProperty(description = "Make Text/Background Color Orange. Do Not customize this.")
  public void OrangeLabelColor(int color){
    orangeLabColor = color;
  }

  @SimpleFunction(description = "Make Oranged Label.")
  public void InitializeOrangedLabel(AndroidViewComponent layout, String text) {
    if(enableBackgroundColor){
      View view = layout.getView();
      TextView tv = new TextView(this.context);
      FrameLayout frameLayout = (FrameLayout) view;
      tv.setText(text);
      tv.setTextColor(Color.WHITE);
      tv.setBackgroundColor(orangeLabColor);  
      frameLayout.addView(tv);
    }
    else {
      View view = layout.getView();
      TextView tv = new TextView(this.context);
      FrameLayout frameLayout = (FrameLayout) view;
      tv.setText(text);
      tv.setTextColor(orangeLabColor);  
      frameLayout.addView(tv);
    }
  }

  @SimpleFunction(description = "Returns the Text")
  public String OrangedLabelText(){
    return "Orange Text";
  }
}