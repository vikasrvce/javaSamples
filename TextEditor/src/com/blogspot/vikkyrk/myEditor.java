package com.blogspot.vikkyrk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class myEditor {
	
	private List<String> mText = new LinkedList<String>();
	private enum editorCommands {INVALID,NEW,I,D,L,E};
	private enum editorState {INVALID,CONTINUE, SAVE, SAVEEXIT, EXIT};
	private commandParser mParser = new commandParser();
	public void processInput(InputStream strm) {
		BufferedReader br = new BufferedReader(new InputStreamReader(strm));
		String s = null;
		boolean loop = true;
		while(loop) {
			try {
				s = br.readLine();
			} catch (IOException e) {
				throw new RuntimeException("processInput error");
			}
			
			mParser.processArguments(s);
			executeCommand(mParser);
			loop = shouldContinue(mParser);
		}
	}
	
	public void executeCommand(commandParser mParser) {
		
		switch(mParser.getEditorCommand()) {
			case NEW:
				mText.add(mParser.getInputText());
				mParser.setEditorState(editorState.CONTINUE);
				break;
			case INVALID:
				System.out.println("Invalid Command, please enter a valid command");
				mParser.setEditorState(editorState.INVALID);
				break;
			case E:
				mParser.setEditorState(editorState.EXIT);
		}
	}

	public boolean shouldContinue(commandParser mParser) {
	    boolean mBool = false;
		switch(mParser.getEditorState()) {
		    case CONTINUE:
		    case INVALID:
			    mBool = true;
			    break;
		    case EXIT:
			    mBool = false;
			    break;
	    }
		return mBool;
	}

	public void printText() {
		Iterator<String> lIter = mText.iterator();
	    
	    while (lIter.hasNext()) {
	    	System.out.println(lIter.next());
	    }
	}
	
	private class commandParser {
		private editorCommands mCommand = editorCommands.INVALID;
		private editorState mState = editorState.INVALID;
		private Integer lineNumber = -1;
		private String textInput = null;
		private String rawInput = null;
		
		public void processArguments(String s) {
			rawInput = textInput = s;
			if(textInput.equals("Exit")) {
				mCommand = editorCommands.E;
			}
			else {
				mCommand = editorCommands.NEW;
			}
		}
		
		public editorState getEditorState() {
			return mState;
		}
		
		public editorCommands getEditorCommand() {
			return mCommand;
		}
		
		public String getInputText() {
			return textInput;
		}
		
		public void setEditorState(editorState st) {
			mState = st;
		}
	}
}
