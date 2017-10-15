package net.tonbot.common;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * A task that is run at a particular frequency.
 */
public abstract class PeriodicTask {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	private final Timer timer;
	private final long periodMs;

	public PeriodicTask(long periodMs) {
		this.timer = new Timer();

		Preconditions.checkArgument(periodMs > 0, "periodMs must be greater than 0.");
		this.periodMs = periodMs;
	}

	public void start() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					performTask();
				} catch (Exception e) {
					LOG.error("Periodic task execution has failed.", e);
				}

			}
		};

		timer.scheduleAtFixedRate(task, 0, periodMs);
	}

	protected abstract void performTask();
}
