package com.googleloading;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by mahes on 18/9/15.
 */
public class LoadingView extends View {

    private Paint blueCirclePaint = new Paint();
    private Paint greenCirclePaint = new Paint();
    private Paint redCirclePaint = new Paint();
    private Paint yellowCirclePaint = new Paint();

    private int indicatorWidth;

    private RectF circleBounds;

    float startAngle;

    float blueSweepAngle;
    float redSweepAngle;
    float greenSweepAngle;
    float yellowSweepAngle;

    float blueStartAngle;
    float redStartAngle;
    float greenStartAngle;
    float yellowStartAngle;

    public static final int STOP_MODE = 0;
    public static final int START_MODE = 1;

    private int currentMode;

    private static final int RED_COLOR = 0xFFDB4437;
    private static final int YELLOW_COLOR = 0xFFF4B400;
    private static final int GREEN_COLOR = 0xFF0F9D58;
    private static final int BLUE_COLOR = 0xFF4285F4;

    private static final int DURATION = 1000;
    private static final int DELAY = 120;

    AnimatorSet animatorSet;

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    void init() {

        blueCirclePaint.setColor(BLUE_COLOR);
        greenCirclePaint.setColor(GREEN_COLOR);
        redCirclePaint.setColor(RED_COLOR);
        yellowCirclePaint.setColor(YELLOW_COLOR);

        blueCirclePaint.setAntiAlias(true);
        greenCirclePaint.setAntiAlias(true);
        redCirclePaint.setAntiAlias(true);
        yellowCirclePaint.setAntiAlias(true);

        blueCirclePaint.setStyle(Paint.Style.STROKE);
        greenCirclePaint.setStyle(Paint.Style.STROKE);
        redCirclePaint.setStyle(Paint.Style.STROKE);
        yellowCirclePaint.setStyle(Paint.Style.STROKE);

        blueCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        greenCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        redCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        yellowCirclePaint.setStrokeCap(Paint.Cap.ROUND);

        blueCirclePaint.setStrokeWidth(indicatorWidth);
        greenCirclePaint.setStrokeWidth(indicatorWidth);
        redCirclePaint.setStrokeWidth(indicatorWidth);
        yellowCirclePaint.setStrokeWidth(indicatorWidth);

    }

    public void setCurrentMode(int mode) {

        if (mode == START_MODE && currentMode == START_MODE)
            return;

        if (mode == STOP_MODE && currentMode == STOP_MODE)
            return;

        currentMode = mode;

        if (currentMode == START_MODE)
            callAnimation();
    }

    void callAnimation() {

        initView();

        if (animatorSet != null) {
            animatorSet.start();
        } else {

            animatorSet = new AnimatorSet();

            ObjectAnimator redSweepAngle = ObjectAnimator.ofFloat(this, "redSweepAngle", startAngle, 360);
            redSweepAngle.setDuration(DURATION);
            redSweepAngle.setInterpolator(new LinearInterpolator());
            redSweepAngle.setStartDelay(0 * DELAY);

            ObjectAnimator yellowSweepAngle = ObjectAnimator.ofFloat(this, "yellowSweepAngle", startAngle, 360);
            yellowSweepAngle.setDuration(DURATION);
            yellowSweepAngle.setInterpolator(new LinearInterpolator());
            yellowSweepAngle.setStartDelay(1 * DELAY);

            ObjectAnimator greenSweepAngle = ObjectAnimator.ofFloat(this, "greenSweepAngle", startAngle, 360);
            greenSweepAngle.setDuration(DURATION);
            greenSweepAngle.setInterpolator(new LinearInterpolator());
            greenSweepAngle.setStartDelay(2 * DELAY);

            ObjectAnimator blueSweepAngle = ObjectAnimator.ofFloat(this, "blueSweepAngle", startAngle, 360);
            blueSweepAngle.setDuration(DURATION);
            blueSweepAngle.setInterpolator(new LinearInterpolator());
            blueSweepAngle.setStartDelay(3 * DELAY);

            ObjectAnimator blueReverseSweepAngle = ObjectAnimator.ofFloat(this, "blueSweepAngle", 360, startAngle);
            blueReverseSweepAngle.setDuration(DURATION);
            blueReverseSweepAngle.setInterpolator(new LinearInterpolator());
            blueReverseSweepAngle.setStartDelay(DURATION + (4 * DELAY) + (0 * DELAY));

            ObjectAnimator greenReverseSweepAngle = ObjectAnimator.ofFloat(this, "greenSweepAngle", 360, startAngle);
            greenReverseSweepAngle.setDuration(DURATION);
            greenReverseSweepAngle.setInterpolator(new LinearInterpolator());
            greenReverseSweepAngle.setStartDelay(DURATION + (4 * DELAY) + (1 * DELAY));

            ObjectAnimator yellowReverseSweepAngle = ObjectAnimator.ofFloat(this, "yellowSweepAngle", 360, startAngle);
            yellowReverseSweepAngle.setDuration(DURATION);
            yellowReverseSweepAngle.setInterpolator(new LinearInterpolator());
            yellowReverseSweepAngle.setStartDelay(DURATION + (4 * DELAY) + (2 * DELAY));

            ObjectAnimator redReverseSweepAngle = ObjectAnimator.ofFloat(this, "redSweepAngle", 360, startAngle);
            redReverseSweepAngle.setDuration(DURATION);
            redReverseSweepAngle.setInterpolator(new LinearInterpolator());
            redReverseSweepAngle.setStartDelay(DURATION + (4 * DELAY) + (3 * DELAY));

            ObjectAnimator blueReverseStartAngle = ObjectAnimator.ofFloat(this, "blueStartAngle", -360F, startAngle);
            blueReverseStartAngle.setDuration(DURATION);
            blueReverseStartAngle.setInterpolator(new LinearInterpolator());
            blueReverseStartAngle.setStartDelay(DURATION + (4 * DELAY) + (0 * DELAY));

            ObjectAnimator greenReverseStartAngle = ObjectAnimator.ofFloat(this, "greenStartAngle", -360F, startAngle);
            greenReverseStartAngle.setDuration(DURATION);
            greenReverseStartAngle.setInterpolator(new LinearInterpolator());
            greenReverseStartAngle.setStartDelay(DURATION + (4 * DELAY) + (1 * DELAY));

            ObjectAnimator yellowReverseStartAngle = ObjectAnimator.ofFloat(this, "yellowStartAngle", -360F, startAngle);
            yellowReverseStartAngle.setDuration(DURATION);
            yellowReverseStartAngle.setInterpolator(new LinearInterpolator());
            yellowReverseStartAngle.setStartDelay(DURATION + (4 * DELAY) + (2 * DELAY));

            ObjectAnimator redReverseStartAngle = ObjectAnimator.ofFloat(this, "redStartAngle", -360F, startAngle);
            redReverseStartAngle.setDuration(DURATION);
            redReverseStartAngle.setInterpolator(new LinearInterpolator());
            redReverseStartAngle.setStartDelay(DURATION + (4 * DELAY) + (3 * DELAY));
            redReverseStartAngle.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {

                    if (currentMode == START_MODE)
                        animatorSet.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });

            animatorSet.playTogether(redSweepAngle, yellowSweepAngle, greenSweepAngle, blueSweepAngle,
                    blueReverseSweepAngle, greenReverseSweepAngle, yellowReverseSweepAngle, redReverseSweepAngle,
                    blueReverseStartAngle, greenReverseStartAngle, yellowReverseStartAngle, redReverseStartAngle);

            animatorSet.start();
        }
    }


    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {

        super.onSizeChanged(width, height, oldWidth, oldHeight);

        int dimension;

        if (getLayoutParams().width < getLayoutParams().height)
            dimension = getLayoutParams().width / 2;
        else
            dimension = getLayoutParams().height / 2;

        indicatorWidth = dimension * 20 / 100;

        int radius = dimension - indicatorWidth / 2;

        init();

        circleBounds = new RectF();
        circleBounds.set(dimension - radius,
                dimension - radius,
                dimension + radius,
                dimension + radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(circleBounds, redStartAngle, redSweepAngle, false, redCirclePaint);
        canvas.drawArc(circleBounds, yellowStartAngle, yellowSweepAngle, false, yellowCirclePaint);
        canvas.drawArc(circleBounds, greenStartAngle, greenSweepAngle, false, greenCirclePaint);
        canvas.drawArc(circleBounds, blueStartAngle, blueSweepAngle, false, blueCirclePaint);
    }

    private void initView() {

        startAngle = -0.1F;

        blueSweepAngle = -0.1F;
        redSweepAngle = -0.1F;
        greenSweepAngle = -0.1F;
        yellowSweepAngle = -0.1F;

        blueStartAngle = -0.1F;
        redStartAngle = -0.1F;
        greenStartAngle = -0.1F;
        yellowStartAngle = -0.1F;

        invalidate();
    }

    public void setBlueSweepAngle(float blueSweepAngle) {
        this.blueSweepAngle = blueSweepAngle;
        invalidate();
    }

    public void setRedSweepAngle(float redSweepAngle) {
        this.redSweepAngle = redSweepAngle;
        invalidate();
    }

    public void setGreenSweepAngle(float greenSweepAngle) {
        this.greenSweepAngle = greenSweepAngle;
        invalidate();
    }

    public void setYellowSweepAngle(float yellowSweepAngle) {
        this.yellowSweepAngle = yellowSweepAngle;
        invalidate();
    }

    public void setBlueStartAngle(float blueStartAngle) {
        this.blueStartAngle = blueStartAngle;
        invalidate();
    }

    public void setRedStartAngle(float redStartAngle) {
        this.redStartAngle = redStartAngle;
        invalidate();
    }

    public void setGreenStartAngle(float greenStartAngle) {
        this.greenStartAngle = greenStartAngle;
        invalidate();
    }

    public void setYellowStartAngle(float yellowStartAngle) {
        this.yellowStartAngle = yellowStartAngle;
        invalidate();
    }

    public int getCurrentMode() {
        return currentMode;
    }
}
