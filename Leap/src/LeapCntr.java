import java.io.IOException;


import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

class LeapListener extends Listener {
	public void onInit(Controller controller) {
		System.out.println("Initialized!");
	}

	public void onConnect(Controller controller) {
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);

	}

	public void onDisconnect(Controller controller) {
		System.out.println("Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("Exited");
	}
	

	public void onFrame(Controller controller) {
			Frame frame = controller.frame();
//			System.out.println(" Frame ID: " + frame.id() +" Time Stamp: " +frame.timestamp()
//				+" Hands Count: "+frame.hands().count()+ " Fingers: "+ frame.fingers().count()
//				+ " Tools: " +frame.tools()+ " Gestures: "+ +frame.gestures().count());
			for(Hand hand: frame.hands()){
				String handType = hand.isLeft() ? "Left Hand:" : "Right Hand";
				System.out.println(handType + ":  " + hand.id() + "Palm Position:   "
						+ hand.palmPosition());
			}
	}
}

public class LeapCntr {

	public static void main(String[] args) {
		Controller controller = new Controller();
		LeapListener listener = new LeapListener();
		controller.addListener(listener);
		System.out.println("Press enter to Quit");
		try {
			System.in.read();
		} catch (IOException e) {

		}
		controller.removeListener(listener);

	}

	public class Thed implements Runnable{

		@Override
		public void run() {
			
			
		}
		
	}
}
